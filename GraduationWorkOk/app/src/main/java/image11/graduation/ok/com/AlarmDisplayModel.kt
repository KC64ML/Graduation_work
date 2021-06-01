package image11.graduation.ok.com

data class AlarmDisplayModel(
    val hour: Int,
    val minute: Int,
    var onOff: Boolean
) //변수선언

{

    val timeText: String
        get() {//get함수 오버라이드
            val h = "%02d".format(if (hour < 12) hour else hour - 12) //스트링의 포맷함수 이용
            val m = "%02d".format(minute)

            return "$h:$m"
        }

    val ampmText: String
        get() {
            return if (hour < 12) "AM" else "PM"
        }

    val onOffText: String
        get() {
            return if (onOff) "약알림 끄기" else "약알림 켜기"
        }

    fun makeDataForDB(): String {
        return "$hour:$minute"
    }

}