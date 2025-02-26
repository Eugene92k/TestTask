import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
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

@Composable
fun TagRow(tags: List<String>) {
    Row(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        tags.forEach { tag ->
            Chip(
                onClick = { },
                label = {
                    Text(
                        text = tag,
                        color = Color.Black,
                        fontSize = 14.sp
                    )
                },
                modifier = Modifier.padding(0.dp),
                colors = ChipDefaults.chipColors(
                    backgroundColor = Color.White,
                ),
                border = ChipDefaults.chipBorder(
                    borderStroke = BorderStroke(1.dp, Color.Black),
                ),
                shape = RoundedCornerShape(8.dp)
            )
        }
    }
}