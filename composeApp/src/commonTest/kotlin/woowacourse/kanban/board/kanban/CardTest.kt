package woowacourse.kanban.board.kanban

import org.junit.Assert.assertThrows
import org.junit.Test
import woowacourse.kanban.board.Tags
import woowacourse.kanban.board.model.Card
import woowacourse.kanban.board.model.Tag
import woowacourse.kanban.board.model.UserInfo

class CardTest {

    @Test
    fun `태그 글자 수가 5자 초과이면 예외`() {
        val given = "너무너무긴태그"

        assertThrows(IllegalArgumentException::class.java) {
            Tag(
                given,
            )
        }
    }

    @Test
    fun `태그 개수가 5개 초과이면 예외`() {
        val given = listOf(Tag("컴포넌트"), Tag("성능"), Tag("컴포넌트"), Tag("성능"), Tag("컴포넌트"), Tag("성능"))

        assertThrows(IllegalArgumentException::class.java) {
            Card(
                title = "제목",
                tags = given,
                user = null,
            )
        }
    }

    @Test
    fun `유저 이름이 공백이면 예외`() {
        val given = "  "

        assertThrows(IllegalArgumentException::class.java) {
            UserInfo(
                name = given,
            )
        }
    }

    @Test
    fun `카드에 유저를 제외한 필드가 모두 비어있으면 예외`() {
        assertThrows(IllegalArgumentException::class.java) {
            Card(
                title = "",
                content = "",
                tags = emptyList(),
                user = null,
            )
        }
    }
}
