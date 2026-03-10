package woowacourse.kanban.board

import androidx.compose.foundation.layout.FlowRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import woowacourse.kanban.board.model.Card
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.User
import woowacourse.kanban.board.ui.KanbanCard

@Composable
@Preview
fun App() {
    MaterialTheme {
        FlowRow {
            KanbanCard(
                Card(
                    title = "LazyColumn 컴포넌트 구현",
                    content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                    tags = listOf(Tag("컴포넌트"), Tag("성능")),
                    user = User(name = "다이노"),
                ),
            )
            KanbanCard(
                Card(
                    title = "LazyColumn 컴포넌트 구현",
                    tags = listOf(Tag("컴포넌트"), Tag("성능")),
                    user = User(name = "다이노"),
                ),
            )
            KanbanCard(
                Card(
                    title = "LazyColumn 컴포넌트 구현",
                    content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다.",
                    user = User(name = "다이노"),
                ),
            )
            KanbanCard(
                Card(
                    title = "LazyColumn 컴포넌트 구현",
                    user = User(name = "다이노"),
                ),
            )
            KanbanCard(
                Card(
                    title = "LazyColumn 컴포넌트 구현",
                    content = "너무너무너무 긴 설명은 두 줄까지만 노출하고 말줄임표로 처리합니다 두 줄까지만 노출하고 말줄임표로 처리합니다",
                    tags = listOf(Tag("너무너무"), Tag("긴 태그"), Tag("최대로"), Tag("5자까지"), Tag("5개제한임")),
                    user = User(name = "너무너무너무 긴 담당자도 한 줄 너무너무너무 긴 담당자도 한 줄"),
                ),
            )
        }
    }
}
