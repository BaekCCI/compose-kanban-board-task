package woowacourse.kanban.board.model

// user를 nullable로 변경 -> 탈퇴한 사용자인 경우를 가정
data class Card(val title: String, val content: String? = null, val tags: List<String> = emptyList(), val user: UserInfo?)
