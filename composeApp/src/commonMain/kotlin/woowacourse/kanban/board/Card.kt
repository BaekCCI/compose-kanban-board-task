package woowacourse.kanban.board

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Card(title: String, content: String, chips: List<String>, user: String) {
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(Color.White)
            .border(width = 1.dp, shape = RoundedCornerShape(10.dp), color = Color(0xffe5e7eb))
            .padding(17.dp, 17.dp, 17.dp, 1.dp)
            .width(286.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Title(title)
        Content(content)
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            chips.take(5).forEach { chip ->
                Chip(chip)
            }
        }
    }
}

@Composable
fun Title(title: String = "제목없음") {
    Text(
        text = title,
        fontSize = 16.sp,
        fontWeight = FontWeight.W500,
        color = Color(0xff101828),
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun Content(content: String) {
    Text(
        text = content,
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        color = Color(0xff4a5565),
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun Chip(content: String) {
    Text(
        text = content.take(5),
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        color = Color(0xff364153),
        modifier = Modifier.clip(shape = RoundedCornerShape(100.dp)).background(Color(0xffF3F4F6))
            .padding(horizontal = 8.dp, vertical = 4.dp),

        )
}

@Composable
@Preview
fun CardPreview() {
    Card(
        title = "제목",
        content = "내용내용내용내용",
        chips = listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임"),
        user = "조디악주황이허닛",
    )
}
