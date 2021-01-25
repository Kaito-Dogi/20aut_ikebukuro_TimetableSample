package app.doggy.timetablesample

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //曜日を管理する変数。
    var dayNum = 0

    //曜日のリスト。
    val dayList: List<String> = listOf("月曜日", "火曜日", "水曜日", "木曜日", "金曜日", "土曜日")

    //背景色のリスト。
    val backgroundList: List<Int> = listOf(
        Color.parseColor("#ffa726"),
        Color.parseColor("#ef5350"),
        Color.parseColor("#29b6f6"),
        Color.parseColor("#66bb6a"),
        Color.parseColor("#ffeb3b"),
        Color.parseColor("#8d6e63"))

    //授業のリスト。
    var classList: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("国語", "数学", "英語", "理科", "", ""),
        mutableListOf("数学", "英語", "理科", "社会", "国語", ""),
        mutableListOf("英語", "理科", "社会", "国語", "", ""),
        mutableListOf("理科", "社会", "国語", "数学", "英語", ""),
        mutableListOf("社会", "国語", "数学", "英語", "", ""),
        mutableListOf("家庭科", "技術", "音楽", "美術", "総合", ""))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //時間割を表示する。
        display(dayNum, classList[dayNum])

        //月曜日の時、戻るボタンを押せなくする。
        if (dayNum == 0) {
            prevButton.isEnabled = false
            prevButton.visibility = View.INVISIBLE
        }

        //進むボタンをクリックした時の処理。
        nextButton.setOnClickListener {
            //曜日を1日進める。
            dayNum += 1

            //戻るボタンを押せるようにする。
            prevButton.isEnabled = true
            prevButton.visibility = View.VISIBLE

            //時間割を表示する。
            display(dayNum, classList[dayNum])

            //ボタンの背景色を設定。
            prevButton.backgroundTintList = ColorStateList.valueOf(backgroundList[dayNum-1])
            if (dayNum != 5) {
                nextButton.backgroundTintList = ColorStateList.valueOf(backgroundList[dayNum+1])
            }

            //土曜日の時、進むボタンを押せないようにする。
            if (dayNum == 5) {
                nextButton.isEnabled = false
                nextButton.visibility = View.INVISIBLE
            }
        }

        //戻るボタンを押した時の処理。
        prevButton.setOnClickListener {
            //曜日を1日戻す。
            dayNum -= 1

            //進むボタンを押せるようにする。
            nextButton.isEnabled = true
            nextButton.visibility = View.VISIBLE

            //時間割を表示する。
            display(dayNum, classList[dayNum])

            //ボタンの背景色を設定。
            nextButton.backgroundTintList = ColorStateList.valueOf(backgroundList[dayNum+1])
            if (dayNum != 0) {
                prevButton.backgroundTintList = ColorStateList.valueOf(backgroundList[dayNum-1])
            }

            //月曜日の時、戻るボタンを押せなくする。
            if (dayNum == 0) {
                prevButton.isEnabled = false
                prevButton.visibility = View.INVISIBLE
            }
        }
    }

    //時間割を表示する。
    fun display(dayNum: Int, classList: MutableList<String>){
        dayTextView.text = dayList[dayNum]
        classTextView1.setText(classList[0])
        classTextView2.setText(classList[1])
        classTextView3.setText(classList[2])
        classTextView4.setText(classList[3])
        classTextView5.setText(classList[4])
        classTextView6.setText(classList[5])
    }


}