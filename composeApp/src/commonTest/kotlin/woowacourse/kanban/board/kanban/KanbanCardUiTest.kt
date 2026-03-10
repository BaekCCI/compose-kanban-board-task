package woowacourse.kanban.board.kanban

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test
import woowacourse.kanban.board.model.Card
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.User
import woowacourse.kanban.board.ui.KanbanCard

@OptIn(ExperimentalTestApi::class)
class KanbanCardUiTest {
    @Test
    fun `모든 필드가 있는 카드 - 제목 설명 태그 유저 모두 노출`() = runComposeUiTest {
        val title = "LazyColumn 컴포넌트 구현"
        val content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."
        val tags = listOf(Tag("컴포넌트"), Tag("성능"))
        val user = User(name = "다이노")

        setContent {
            KanbanCard(Card(title = title, content = content, tags = tags, user = user))
        }

        onNodeWithText(title).assertIsDisplayed()
        onNodeWithText(content).assertIsDisplayed()
        onNodeWithText("컴포넌트", useUnmergedTree = true).assertIsDisplayed()
        onNodeWithText("성능", useUnmergedTree = true).assertIsDisplayed()
        onNodeWithText(user.name).assertIsDisplayed()
    }

    @Test
    fun `제목 필드가 없는 카드 - 제목 없음 표시`() = runComposeUiTest {
        val title = null
        val content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."
        val tags = listOf(Tag("컴포넌트"), Tag("성능"))
        val user = User(name = "다이노")

        setContent {
            KanbanCard(Card(title = title, content = content, tags = tags, user = user))
        }

        onNodeWithText(DEFAULT_TITLE).assertIsDisplayed()
    }

    @Test
    fun `유저가 null인 카드 - 알 수 없는 유저 노출`() = runComposeUiTest {
        val title = "LazyColumn 컴포넌트 구현"
        val content = "세로 스크롤 가능한 리스트 컴포넌트를 만들고 성능 최적화를 적용합니다."
        val tags = listOf(Tag("컴포넌트"), Tag("성능"))
        val user = null

        setContent {
            KanbanCard(Card(title = title, content = content, tags = tags, user = user))
        }

        onNodeWithText(UNKNOWN_USER).assertIsDisplayed()
    }

    companion object {
        private const val DEFAULT_TITLE = "제목 없음"
        private const val UNKNOWN_USER = "알 수 없는 유저"
    }
}
