package woowacourse.kanban.board

data class CardData(
    val title: String,
    val content: String? = null,
    val chips: List<String> = emptyList(),
    val user: String,
)
