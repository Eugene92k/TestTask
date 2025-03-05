import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.Chip
import androidx.wear.compose.material.ChipDefaults

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun TagRow(tags: List<String>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        tags.forEach { tag ->
            Chip(
                modifier = Modifier
                    .padding(0.dp),

                onClick = { },
                label = {
                    Text(
                        text = tag,
                        color = Color.Black,
                        fontSize = 12.sp,
                    )
                },
                colors = ChipDefaults.chipColors(
                    backgroundColor = Color.White,
                ),
                border = ChipDefaults.chipBorder(
                    borderStroke = BorderStroke(1.dp, Color.Black),
                ),
                shape = RoundedCornerShape(8.dp),
            )
        }
    }
}