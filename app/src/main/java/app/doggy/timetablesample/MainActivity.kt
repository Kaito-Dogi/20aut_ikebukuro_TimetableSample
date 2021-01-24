package app.doggy.timetablesample

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //曜日を管理する変数。
    var dayNum = 0

    //曜日のリスト。
    val dayList: List<String> = listOf("月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日")

    //背景色のリスト。
    val backgroundList: List<Int> = listOf(
        Color.parseColor("#EF810F"),
        Color.parseColor("#CB4042"),
        Color.parseColor("#ACDBDA"),
        Color.parseColor("#4D8169"),
        Color.parseColor("#EFBF3D"),
        Color.parseColor("#B1643B"))

    //授業のリスト。
    var classList: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("国語", "数学", "英語", "理科", "社会"),
        mutableListOf("数学", "英語", "理科", "社会", "国語"),
        mutableListOf("英語", "理科", "社会", "国語", "数学"),
        mutableListOf("理科", "社会", "国語", "数学", "英語"),
        mutableListOf("社会", "国語", "数学", "英語", "理科"),
        mutableListOf("家庭科", "技術", "音楽", "美術", "総合"))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //時間割を表示する。
        display(dayNum, classList[dayNum])

        //月曜日の時、戻るボタンを押せなくする。
        if (dayNum == 0) {
            prevButton.isEnabled = false
        }

        //進むボタンをクリックした時の処理。
        nextButton.setOnClickListener {
            //曜日を1日進める。
            dayNum += 1

            //戻るボタンを押せるようにする。
            prevButton.isEnabled = true

            //背景色を設定。
            background.backgroundTintList = ColorStateList.valueOf(backgroundList[dayNum])

            //時間割を表示する。
            display(dayNum, classList[dayNum])

            //土曜日の時、進むボタンを押せないようにする。
            if (dayNum == 5) {
                nextButton.isEnabled = false
            }
        }

        //戻るボタンを押した時の処理。
        prevButton.setOnClickListener {
            //曜日を1日戻す。
            dayNum -= 1

            //進むボタンを押せるようにする。
            nextButton.isEnabled = true

            //背景色を設定。
            background.backgroundTintList = ColorStateList.valueOf(backgroundList[dayNum])

            //時間割を表示する。
            display(dayNum, classList[dayNum])

            //月曜日の時、戻るボタンを押せなくする。
            if (dayNum == 0) {
                prevButton.isEnabled = false
            }
        }
    }

    //時間割を表示する。
    fun display(dayNum: Int, classList: MutableList<String>){
        dayTextView.text = dayList[dayNum]
        classTextView1.text = classList[0]
        classTextView2.text = classList[1]
        classTextView3.text = classList[2]
        classTextView4.text = classList[3]
        classTextView5.text = classList[4]
    }


}