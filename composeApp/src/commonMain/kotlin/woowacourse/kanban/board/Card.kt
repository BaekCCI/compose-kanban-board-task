package woowacourse.kanban.board

data class Card(val title: String, val content: String? = null, val chips: List<String> = emptyList(), val user: UserInfo)
