package com.example.starengine.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.starengine.R
import com.example.starengine.database.AppDatabase
import com.example.starengine.databinding.ActivityUpgradesBinding
import com.example.starengine.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UpgradesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUpgradesBinding
    private var upgrade: com.example.starengine.database.entities.Upgrade? = null
    private var totalPoints: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpgradesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadUpgrade()
        calculateTotalPoints()

        setupUpgradeButtons()
    }

    private fun loadUpgrade() {
        lifecycleScope.launch(Dispatchers.IO) {
            val database = AppDatabase.getDatabase(this@UpgradesActivity)
            var currentUpgrade = database.upgradeDao().getUpgradeSync()
            
            // If upgrade doesn't exist, create and insert it
            if (currentUpgrade == null) {
                currentUpgrade = com.example.starengine.database.entities.Upgrade(
                    id = 1,
                    speed = 1.0f,
                    fireRate = 1.0f,
                    power = 1,
                    shipWidth = 1.0f
                )
                database.upgradeDao().insertUpgrade(currentUpgrade)
            }
            
            upgrade = currentUpgrade
            
            launch(Dispatchers.Main) {
                updateUI()
            }
        }
    }

    private fun calculateTotalPoints() {
        lifecycleScope.launch(Dispatchers.IO) {
            val database = AppDatabase.getDatabase(this@UpgradesActivity)
            val scores = database.scoreDao().getAllScores()
            totalPoints = scores.sumOf { it.points }
            
            launch(Dispatchers.Main) {
                updateUI()
            }
        }
    }

    private fun updateUI() {
        val currentUpgrade = upgrade ?: return

        // Fire Rate
        val fireRateLevel = (currentUpgrade.fireRate * 10).toInt()
        binding.tvFireRateLevel.text = "Level: $fireRateLevel"
        val fireRateCost = Constants.FIRE_RATE_UPGRADE_COST * fireRateLevel
        binding.tvFireRateCost.text = "Cost: $fireRateCost points"
        binding.btnUpgradeFireRate.isEnabled = totalPoints >= fireRateCost

        // Bullet Power
        binding.tvBulletPowerLevel.text = "Level: ${currentUpgrade.power}"
        val bulletPowerCost = Constants.BULLET_POWER_UPGRADE_COST * currentUpgrade.power
        binding.tvBulletPowerCost.text = "Cost: $bulletPowerCost points"
        binding.btnUpgradeBulletPower.isEnabled = totalPoints >= bulletPowerCost

        // Ship Width
        val shipWidthLevel = (currentUpgrade.shipWidth * 10).toInt()
        binding.tvShipWidthLevel.text = "Level: $shipWidthLevel"
        val shipWidthCost = Constants.SHIP_WIDTH_UPGRADE_COST * shipWidthLevel
        binding.tvShipWidthCost.text = "Cost: $shipWidthCost points"
        binding.btnUpgradeShipWidth.isEnabled = totalPoints >= shipWidthCost
    }

    private fun setupUpgradeButtons() {
        binding.btnUpgradeFireRate.setOnClickListener {
            upgradeFireRate()
        }

        binding.btnUpgradeBulletPower.setOnClickListener {
            upgradeBulletPower()
        }

        binding.btnUpgradeShipWidth.setOnClickListener {
            upgradeShipWidth()
        }
    }

    private fun upgradeFireRate() {
        val currentUpgrade = upgrade ?: return
        val fireRateLevel = (currentUpgrade.fireRate * 10).toInt()
        val cost = Constants.FIRE_RATE_UPGRADE_COST * fireRateLevel

        if (totalPoints >= cost) {
            lifecycleScope.launch(Dispatchers.IO) {
                val database = AppDatabase.getDatabase(this@UpgradesActivity)
                val newUpgrade = currentUpgrade.copy(fireRate = currentUpgrade.fireRate + 0.1f)
                database.upgradeDao().updateUpgrade(newUpgrade)
                upgrade = newUpgrade
                
                launch(Dispatchers.Main) {
                    Toast.makeText(
                        this@UpgradesActivity,
                        "Fire Rate upgraded!",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI()
                }
            }
        } else {
            Toast.makeText(
                this,
                R.string.insufficient_points,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun upgradeBulletPower() {
        val currentUpgrade = upgrade ?: return
        val cost = Constants.BULLET_POWER_UPGRADE_COST * currentUpgrade.power

        if (totalPoints >= cost) {
            lifecycleScope.launch(Dispatchers.IO) {
                val database = AppDatabase.getDatabase(this@UpgradesActivity)
                val newUpgrade = currentUpgrade.copy(power = currentUpgrade.power + 1)
                database.upgradeDao().updateUpgrade(newUpgrade)
                upgrade = newUpgrade
                
                launch(Dispatchers.Main) {
                    Toast.makeText(
                        this@UpgradesActivity,
                        "Bullet Power upgraded!",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI()
                }
            }
        } else {
            Toast.makeText(
                this,
                R.string.insufficient_points,
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun upgradeShipWidth() {
        val currentUpgrade = upgrade ?: return
        val shipWidthLevel = (currentUpgrade.shipWidth * 10).toInt()
        val cost = Constants.SHIP_WIDTH_UPGRADE_COST * shipWidthLevel

        if (totalPoints >= cost) {
            lifecycleScope.launch(Dispatchers.IO) {
                val database = AppDatabase.getDatabase(this@UpgradesActivity)
                val newUpgrade = currentUpgrade.copy(shipWidth = currentUpgrade.shipWidth + 0.1f)
                database.upgradeDao().updateUpgrade(newUpgrade)
                upgrade = newUpgrade
                
                launch(Dispatchers.Main) {
                    Toast.makeText(
                        this@UpgradesActivity,
                        "Ship Width upgraded!",
                        Toast.LENGTH_SHORT
                    ).show()
                    updateUI()
                }
            }
        } else {
            Toast.makeText(
                this,
                R.string.insufficient_points,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}