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

private const val DEFAULT_TITLE = "제목 없음"
private const val UNKNOWN_USER = "알 수 없는 유저"
private const val TITLE_MAX_LINE = 1
private const val CONTENT_MAX_LINE = 2
private const val MAX_CHIP_SIZE = 5
private const val MAX_CHIP_LENGTH = 5

@Composable
fun KanbanCard(card: Card) {
    Column(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .background(Color.White)
            .border(width = 1.dp, shape = RoundedCornerShape(10.dp), color = Gray200)
            .padding(17.dp)
            .width(286.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        CardTitle(card.title)
        card.content?.let { content -> Content(content) }
        if (card.tags.isNotEmpty()) Tags(card.tags)
        Box {
            HorizontalDivider(color = Gray100, thickness = 1.dp)
            UserProfile(card.user)
        }
    }
}

@Composable
fun CardTitle(title: String) {
    Text(
        text = title.ifBlank { DEFAULT_TITLE },
        fontSize = 16.sp,
        fontWeight = FontWeight.W500,
        color = Gray900,
        maxLines = TITLE_MAX_LINE,
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
        maxLines = CONTENT_MAX_LINE,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
fun Tags(tags: List<String>, maxSize: Int = MAX_CHIP_SIZE, maxLength: Int = MAX_CHIP_LENGTH) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        tags.take(maxSize).forEach { chip ->
            Chip(chip, maxLength)
        }
    }
}

@Composable
fun Chip(content: String, maxLength: Int = MAX_CHIP_LENGTH) {
    Text(
        text = content.take(maxLength),
        fontSize = 12.sp,
        fontWeight = FontWeight.W400,
        color = Gray700,
        modifier = Modifier
            .clip(shape = RoundedCornerShape(100.dp))
            .background(Gray100)
            .padding(horizontal = 8.dp, vertical = 4.dp),
    )
}

@Composable
fun UserProfile(userInfo: UserInfo?) {
    Row(
        modifier = Modifier.padding(vertical = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Box(
            modifier = Modifier
                .size(24.dp).clip(CircleShape)
                .background(color = Color.White)
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
            text = userInfo?.name ?: UNKNOWN_USER,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp,
            color = Gray700,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
        )
    }
}

class CardPreviewParameterProvider : PreviewParameterProvider<Card> {
    override val values = sequenceOf(
        Card(
            title = "LazyColumn 컴포넌트 구현",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tags = listOf("컴포넌트", "성능"),
            user = UserInfo(name = "다이노"),
        ),
        Card(
            title = "LazyColumn 컴포넌트 구현",
            tags = listOf("컴포넌트", "성능"),
            user = UserInfo(name = "다이노"),
        ),
        Card(
            title = "LazyColumn 컴포넌트 구현",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            user = UserInfo(name = "다이노"),
        ),
        Card(
            title = "LazyColumn 컴포넌트 구현",
            user = UserInfo(name = "다이노"),
        ),
        Card(
            title = "LazyColumn 컴포넌트 구현",
            content = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노출하고 말줄임표로 처리합니다",
            tags = listOf("너무너무", "긴 태그", "최대로", "5자까지", "5개제한임"),
            user = UserInfo(name = "너무너무너무 긴 담당자도 한 줄 너무너무너무 긴 담당자도 한 줄"),
        ),
    )
}

@Composable
@Preview
fun KanbanCardPreview(@PreviewParameter(CardPreviewParameterProvider::class) data: Card) {
    KanbanCard(data)
}
