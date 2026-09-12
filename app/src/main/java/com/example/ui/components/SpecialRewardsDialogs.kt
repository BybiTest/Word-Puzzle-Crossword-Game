package com.example.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.ui.theme.GameTheme

// ====================================================================
// نکته مهم: اگر کلاس داده‌ی تو نام دیگری دارد (مثلاً RewardItem)، 
// نام SpecialReward را در خطوط زیر به نام دقیق کلاس خودت تغییر بده.
// ====================================================================
data class SpecialReward(
    val id: String,
    val name: String,
    val subtitle: String,
    val icon: androidx.compose.ui.graphics.vector.ImageVector = Icons.Default.Star
)

@Composable
fun SpecialRewardsDialog(
    isOpen: Boolean,
    theme: GameTheme,
    rewards: List<SpecialReward> = emptyList(), // لیست جوایز
    onClaimReward: (SpecialReward) -> Unit,
    onDismiss: () -> Unit
) {
    if (!isOpen) return

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(24.dp),
            color = theme.cardBackground, // رفع خطای Unresolved reference
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .testTag("special_rewards_dialog")
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "جوایز ویژه",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 20.sp,
                    color = theme.textColor
                )

                Spacer(modifier = Modifier.height(16.dp))

                // رفع خطای Composable context: این حلقه داخل یک تابع @Composable است
                rewards.forEach { reward ->
                    RewardItemCard(
                        reward = reward,
                        theme = theme,
                        onClick = { onClaimReward(reward) }
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = onDismiss,
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = theme.primaryVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("بستن", fontWeight = FontWeight.Bold, fontSize = 14.sp, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun RewardItemCard(
    reward: SpecialReward,
    theme: GameTheme,
    onClick: () -> Unit
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = theme.cardBackground),
        // رفع خطای ابهام: استفاده صریح از width و color
        border = BorderStroke(width = 1.5.dp, color = theme.cardBorder),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .testTag("reward_item_${reward.id}")
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                        // رفع خطای ابهام: استفاده صریح از brush
                        .background(brush = theme.letterButtonGradient),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = reward.icon,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column {
                    Text(
                        text = reward.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = theme.textColor
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = reward.subtitle,
                        fontSize = 12.sp,
                        color = theme.textSecondary
                    )
                }
            }

            Surface(
                shape = RoundedCornerShape(8.dp),
                color = theme.accent.copy(alpha = 0.15f)
            ) {
                Text(
                    text = "دریافت",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = theme.accent,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
                )
            }
        }
    }
}

// اگر دیالوگ خاص دیگری هم در این فایل داشتی، ساختار آن باید به این شکل باشد:
@Composable
fun AnotherSpecialDialog( // نام تابع را مطابق نیاز خود تغییر دهید
    isOpen: Boolean,
    theme: GameTheme,
    onDismiss: () -> Unit
) {
    if (!isOpen) return

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(20.dp),
            // رفع خطای ابهام: استفاده صریح از color
            color = theme.cardBackground, 
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    // رفع خطای ابهام: استفاده صریح از brush
                    .background(brush = theme.backgroundGradient)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "عنوان دیالوگ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = theme.textColor
                )
                
                Spacer(modifier = Modifier.height(16.dp))
                
                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.buttonColors(containerColor = theme.primary)
                ) {
                    Text("متوجه شدم", color = Color.White)
                }
            }
        }
    }
}
