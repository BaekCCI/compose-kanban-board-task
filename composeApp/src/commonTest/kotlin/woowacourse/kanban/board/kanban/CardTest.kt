package woowacourse.kanban.board.kanban

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails
import woowacourse.kanban.board.model.Card
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.User

class CardTest {

    @Test
    fun `태그 개수가 5개 초과이면 예외`() {
        val given = listOf(Tag("컴포넌트"), Tag("성능"), Tag("컴포넌트"), Tag("성능"), Tag("컴포넌트"), Tag("성능"))

        assertFails {
            Card(
                title = "제목",
                tags = given,
                user = null,
            )
        }
    }

    @Test
    fun `카드에 유저를 제외한 필드가 모두 비어있으면 예외`() {
        assertFails {
            Card(
                title = "",
                content = "",
                tags = emptyList(),
                user = null,
            )
        }
    }

    @Test
    fun `카드에 타이틀만 있어도 생성 성공`() {
        val given = "타이틀"
        assertEquals(given, Card(title = given, user = null).title)
    }

    @Test
    fun `카드에 내용만 있어도 생성 성공`() {
        val given = "내용"
        assertEquals(given, Card(title = null, content = given, user = null).content)
    }

    @Test
    fun `카드에 태그만 있어도 생성 성공`() {
        val given = listOf(Tag("컴포넌트"), Tag("성능"))
        assertEquals(given, Card(title = null, tags = given, user = null).tags)
    }

    @Test
    fun `카드에 태그가 5개 이하면 생성 성공`() {
        val given = listOf(Tag("컴포넌트"), Tag("성능"), Tag("컴포넌트"), Tag("성능"), Tag("컴포넌트"))
        Card(title = null, tags = given, user = null)
    }

    @Test
    fun `카드에 모든 필드가 있으면 생성 성공`() {
        val givenTitle = "타이틀"
        val givenContent = "내용"
        val givenTags = listOf(Tag("컴포넌트"), Tag("성능"))
        val givenUser = User("다이노")

        val card = Card(
            title = givenTitle,
            content = givenContent,
            tags = givenTags,
            user = givenUser,
        )
        assertEquals(givenTitle, card.title)
        assertEquals(givenContent, card.content)
        assertEquals(givenTags.toSet(), card.tags.toSet())
        assertEquals(givenUser, card.user)
    }
}
