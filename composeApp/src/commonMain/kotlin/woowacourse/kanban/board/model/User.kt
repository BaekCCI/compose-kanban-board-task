package woowacourse.kanban.board.model

data class User(val name: String, val profileImg: String? = null) {
    init {
        require(name.isNotBlank()) {
            "이름은 공백일 수 없습니다."
        }
    }
}
