package woowacourse.kanban.board

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Card(
    cardData: CardData,
) {
    val shape = RoundedCornerShape(10.dp)

    Column(
        modifier = Modifier
            .clip(shape = shape)
            .background(Color.White)
            .border(width = 1.dp, shape = shape, color = Gray200)
            .padding(17.dp)
            .width(286.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Title(cardData.title)
        if (cardData.content != null) Content(cardData.content)
        if (cardData.chips.isNotEmpty()) Chips(cardData.chips)
        User(cardData.user)
    }
}

@Composable
fun Title(title: String) {
    Text(
        text = title.ifEmpty { "제목 없음" },
        fontSize = 16.sp,
        fontWeight = FontWeight.W500,
        color = Gray900,
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
        color = Gray600,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun Chips(tags: List<String>, maxSize: Int = 5, maxLength: Int = 5) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        tags.take(maxSize).forEach { chip ->
            Chip(chip.take(maxLength))
        }
    }
}

@Composable
fun Chip(content: String) {
    Text(
        text = content,
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        color = Gray700,
        modifier = Modifier.clip(shape = RoundedCornerShape(100.dp)).background(Gray100)
            .padding(horizontal = 8.dp, vertical = 4.dp),
    )
}

@Composable
fun User(name: String) {
    Box {
        HorizontalDivider(color = Gray100, thickness = 1.dp)

        Row(
            modifier = Modifier.padding(vertical = 10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier.size(24.dp).clip(CircleShape).background(color = Color.White)
                    .border(width = 2.dp, color = Gray500, shape = CircleShape),
            ) {
                Icon(
                    imageVector = Icons.Default.AccountBox,
                    contentDescription = "profile image",
                    tint = Gray500,
                    modifier = Modifier.clip(CircleShape).requiredSize(size = 33.dp),
                )
            }
            Text(
                text = name.ifBlank { "알 수 없음" },
                fontWeight = FontWeight.W500,
                fontSize = 14.sp,
                color = Gray700,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

class CardPreviewParameterProvider : PreviewParameterProvider<CardData> {
    override val values = sequenceOf(
        CardData(
            title = "LazyColumn 컴포넌트 구현",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            chips = listOf("컴포넌트", "성능"),
            user = "다이노",
        ),
        CardData(
            title = "LazyColumn 컴포넌트 구현",
            chips = listOf("컴포넌트", "성능"),
            user = "다이노",
        ),
        CardData(
            title = "LazyColumn 컴포넌트 구현",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            user = "다이노",
        ),
        CardData(
            title = "LazyColumn 컴포넌트 구현",
            user = "다이노",
        ),
        CardData(
            title = "LazyColumn 컴포넌트 구현",
            content = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노출하고 말줄임표로 처리합니다",
            chips = listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임"),
            user = "너무너무너무 긴 담당자도 한 줄 너무너무너무 긴 담당자도 한 줄",
        ),
        CardData(
            title = "",
            content = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노출하고 말줄임표로 처리합니다",
            chips = listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임"),
            user = "   ",
        ),
    )
}

@Composable
@Preview
fun CardPreview(
    @PreviewParameter(CardPreviewParameterProvider::class) data: CardData,
) {
    Card(data)
}
