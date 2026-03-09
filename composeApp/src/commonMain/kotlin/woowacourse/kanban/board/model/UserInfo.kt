package woowacourse.kanban.board.model

data class UserInfo(val name: String, val profileImg: String? = null) {
    init {
        require(name.isNotBlank()) {
            "이름은 공백일 수 없습니다."
        }
    }
}
