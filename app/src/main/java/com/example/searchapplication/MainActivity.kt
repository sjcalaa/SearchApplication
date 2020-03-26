package com.example.searchapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val dog: ArrayList<Dog> = arrayListOf(
        Dog(
            "aaa",
            3,
            "말티즈",
            "https://lh3.googleusercontent.com/proxy/UpMK0Lt7ewoyng0w4UjQJCzsERalzMLo-_h88yeeEhkWGjQbF0zL4-7kV7Q9j9QujFVYiab7uFbAOLc-ENCqgbWBPS76JALLEH-dAc_NrE14LyWNf7HdJ9gdJ4OdmpJlgWOZ6buGhdq6gQjufQbFZwVTAGsKBkCV"
        ), Dog(
            "bbb",
            7,
            "잡종",
            "https://img.insight.co.kr/static/2019/03/20/700/5180uv5s4g478m2dw1nm.jpg"
        ), Dog(
            "ccc",
            2,
            "요크셔테리어",
            "https://ninedog.cafe24.com/web/img/show/yoki1.jpg"
        ), Dog(
            "abab",
            11,
            "슈나우저",
            "https://myanimals.co.kr/wp-content/uploads/2018/04/Schnauzer-dogs.jpg"
        ), Dog(
            "acac",
            1,
            "말티즈",
            "data:image/jpeg;base64,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"
        ), Dog(
            "baba",
            5,
            "포메라니안",
            "https://images.mypetlife.co.kr/wp-content/uploads/2018/03/06153453/KakaoTalk_20180228_153728551.jpg"
        ), Dog(
            "bcbc",
            22,
            "호랑이",
            "https://dimg.donga.com/wps/NEWS/IMAGE/2019/10/31/98154707.2.jpg"
        ), Dog(
            "caca",
            6,
            "보더콜리",
            "https://lh3.googleusercontent.com/proxy/YhfHW4l2JLyN0ZHNAbAzUN_9_Fk8OVNPQeXyjRW5y3ki7uplqWsYaWEQrVrBJdubkJxUpiinw055VxfQLlpCHaxHcsfR_Jt4xJ-LutJv22uuDX7-LaVvx-JOKgQW2EwdT-ISqafTEecyo-DGdAGoC8WAR8ITnoQpFFGotNIVOkdcZ5vLeVjyuMIumpOe0Rn-eqrtaD5D-XumW1ulTHrBDEdincXGyG6vEY7qiZqSYQfDxnqHan10Gj4Zbr3fA_Orl1SbdocrF9D68nt1zV-b4tX7RtNWTIlT1ein8BPvvhCRvMVJxZILX0EgUE42Qvp9sqFplNk"
        ), Dog(
            "cbcb",
            8,
            "웰시코기",
            "https://post-phinf.pstatic.net/MjAxNzA5MjBfMjI1/MDAxNTA1ODg0NjMyNDgw.9GzMHmgvTppZHJAb2BOq1pdQJQqX79NTv003csX-Q6cg.k88VnGh5SQbQiZkDllPRYrmX0kWu1kd0u3CsqWPkfRsg.PNG/20170920_134618.png?type=w800_q75"
        ), Dog(
            "골드",
            13,
            "골든 리트리버",
            "https://t1.daumcdn.net/liveboard/petnu/cd6d427f61da403db68e45cd4fc314f8.JPG"
        ), Dog(
            "흑구",
            8,
            "셰퍼드",
            "https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile30.uf.tistory.com%2Fimage%2F993D9E4E5AFBCA2C251F97"
        ), Dog(
            "멍뭉이",
            6,
            "도베르만",
            "https://mblogthumb-phinf.pstatic.net/MjAxODA0MjhfMTUx/MDAxNTI0OTA2NDE0NTA1.AOOLsOJc5i8dh9LdvIMpiZ0CnWEapNUoEBF1wCkvPpQg.wkUjH9zTBLNo0wShyI4AFxbsnvxnkZWUiURmaw-OjtIg.JPEG.trollcig/doberman-893931_1920.jpg?type=w800"
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter(dog)
        val mAdapter: Adapter = Adapter(dog)
        searchEdt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                mAdapter.filter(s.toString())
                setAdapter(dog)
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })


    }

    fun setAdapter(dog:ArrayList<Dog>) {
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = Adapter(dog)
    }


    /*fun addData() {
        dog = arrayListOf(
            Dog(
                "aaa",
                3,
                "말티즈",
                "https://lh3.googleusercontent.com/proxy/UpMK0Lt7ewoyng0w4UjQJCzsERalzMLo-_h88yeeEhkWGjQbF0zL4-7kV7Q9j9QujFVYiab7uFbAOLc-ENCqgbWBPS76JALLEH-dAc_NrE14LyWNf7HdJ9gdJ4OdmpJlgWOZ6buGhdq6gQjufQbFZwVTAGsKBkCV"
            ), Dog(
                "bbb",
                7,
                "잡종",
                "https://img.insight.co.kr/static/2019/03/20/700/5180uv5s4g478m2dw1nm.jpg"
            ), Dog(
                "ccc",
                2,
                "요크셔테리어",
                "https://ninedog.cafe24.com/web/img/show/yoki1.jpg"
            ), Dog(
                "abab",
                11,
                "슈나우저",
                "https://myanimals.co.kr/wp-content/uploads/2018/04/Schnauzer-dogs.jpg"
            ), Dog(
                "acac",
                1,
                "말티즈",
                "data:image/jpeg;base64,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"
            ), Dog(
                "baba",
                5,
                "포메라니안",
                "https://images.mypetlife.co.kr/wp-content/uploads/2018/03/06153453/KakaoTalk_20180228_153728551.jpg"
            ), Dog(
                "bcbc",
                22,
                "호랑이",
                "https://dimg.donga.com/wps/NEWS/IMAGE/2019/10/31/98154707.2.jpg"
            ), Dog(
                "caca",
                6,
                "보더콜리",
                "https://lh3.googleusercontent.com/proxy/YhfHW4l2JLyN0ZHNAbAzUN_9_Fk8OVNPQeXyjRW5y3ki7uplqWsYaWEQrVrBJdubkJxUpiinw055VxfQLlpCHaxHcsfR_Jt4xJ-LutJv22uuDX7-LaVvx-JOKgQW2EwdT-ISqafTEecyo-DGdAGoC8WAR8ITnoQpFFGotNIVOkdcZ5vLeVjyuMIumpOe0Rn-eqrtaD5D-XumW1ulTHrBDEdincXGyG6vEY7qiZqSYQfDxnqHan10Gj4Zbr3fA_Orl1SbdocrF9D68nt1zV-b4tX7RtNWTIlT1ein8BPvvhCRvMVJxZILX0EgUE42Qvp9sqFplNk"
            ), Dog(
                "cbcb",
                8,
                "웰시코기",
                "https://post-phinf.pstatic.net/MjAxNzA5MjBfMjI1/MDAxNTA1ODg0NjMyNDgw.9GzMHmgvTppZHJAb2BOq1pdQJQqX79NTv003csX-Q6cg.k88VnGh5SQbQiZkDllPRYrmX0kWu1kd0u3CsqWPkfRsg.PNG/20170920_134618.png?type=w800_q75"
            ), Dog(
                "골드",
                13,
                "골든 리트리버",
                "https://t1.daumcdn.net/liveboard/petnu/cd6d427f61da403db68e45cd4fc314f8.JPG"
            ), Dog(
                "흑구",
                8,
                "셰퍼드",
                "https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile30.uf.tistory.com%2Fimage%2F993D9E4E5AFBCA2C251F97"
            ), Dog(
                "멍뭉이",
                6,
                "도베르만",
                "https://mblogthumb-phinf.pstatic.net/MjAxODA0MjhfMTUx/MDAxNTI0OTA2NDE0NTA1.AOOLsOJc5i8dh9LdvIMpiZ0CnWEapNUoEBF1wCkvPpQg.wkUjH9zTBLNo0wShyI4AFxbsnvxnkZWUiURmaw-OjtIg.JPEG.trollcig/doberman-893931_1920.jpg?type=w800"
            )
        )
    }*/
}
