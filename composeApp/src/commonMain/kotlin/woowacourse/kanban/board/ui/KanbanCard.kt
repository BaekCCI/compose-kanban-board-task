package woowacourse.kanban.board.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import woowacourse.kanban.board.Gray100
import woowacourse.kanban.board.Gray200
import woowacourse.kanban.board.Gray600
import woowacourse.kanban.board.Gray900
import woowacourse.kanban.board.model.Card
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.User

private const val DEFAULT_TITLE = "제목 없음"
private const val TITLE_MAX_LINE = 1
private const val CONTENT_MAX_LINE = 2

@Composable
fun KanbanCard(card: Card, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
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
            UserProfile(card.user, Modifier.padding(10.dp))
        }
    }
}

@Composable
private fun CardTitle(title: String?) {
    Text(
        text = if (title.isNullOrBlank()) DEFAULT_TITLE else title,
        fontSize = 16.sp,
        fontWeight = FontWeight.W500,
        color = Gray900,
        maxLines = TITLE_MAX_LINE,
        overflow = TextOverflow.Ellipsis,
    )
}

@Composable
private fun Content(content: String) {
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
private fun Tags(tags: List<Tag>) {
    FlowRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        tags.forEach { tag ->
            Chip(tag.content)
        }
    }
}

class CardPreviewParameterProvider : PreviewParameterProvider<Card> {
    override val values = sequenceOf(
        Card(
            title = "LazyColumn 컴포넌트 구현",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            tags = listOf(Tag("컴포넌트"), Tag("성능")),
            user = User(name = "다이노"),
        ),
        Card(
            title = "LazyColumn 컴포넌트 구현",
            tags = listOf(Tag("컴포넌트"), Tag("성능")),
            user = User(name = "다이노"),
        ),
        Card(
            title = "LazyColumn 컴포넌트 구현",
            content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
            user = User(name = "다이노"),
        ),
        Card(
            title = "LazyColumn 컴포넌트 구현",
            user = User(name = "다이노"),
        ),
        Card(
            title = "LazyColumn 컴포넌트 구현",
            content = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노출하고 말줄임표로 처리합니다",
            tags = listOf(Tag("너무너무"), Tag("긴 태그"), Tag("최대로"), Tag("5자까지"), Tag("5개제한임")),
            user = User(name = "너무너무너무 긴 담당자도 한 줄 너무너무너무 긴 담당자도 한 줄"),
        ),
    )
}

@Composable
@Preview
fun KanbanCardPreview(@PreviewParameter(CardPreviewParameterProvider::class) card: Card) {
    KanbanCard(card)
}
