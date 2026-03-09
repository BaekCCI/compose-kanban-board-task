package woowacourse.kanban.board

data class UserInfo(val name: String, val profileImg: String? = null) {
    init {
        require(name.isNotBlank()) {
            "이름은 공백일 수 없습니다."
        }
    }
}
