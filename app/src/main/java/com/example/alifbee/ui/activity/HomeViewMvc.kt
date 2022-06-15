import android.content.Context
import android.content.Intent
import android.view.MotionEvent
import android.view.View

interface HomeViewMvc {

    interface Listener {
        fun onMoreByUsClicked(intent: Intent)
    }

    fun getRootView(): View
    fun getContext(): Context
    fun <T : View> findViewById(id: Int): T
    fun setOnTouchListener(v: View, event: MotionEvent): Boolean
    fun chek(way: Int)
}