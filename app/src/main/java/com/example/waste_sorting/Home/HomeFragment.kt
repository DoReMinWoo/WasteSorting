package com.example.waste_sorting.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.waste_sorting.HomeAdapter
import com.example.waste_sorting.HomeData
import com.example.waste_sorting.R
import kotlinx.android.synthetic.main.fragment_home.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView.layoutManager = GridLayoutManager(activity, 2)
        recyclerView.adapter = HomeAdapter(DataList)

    }

    val DataList = arrayListOf(
        HomeData(R.drawable.home_plastic, "플라스틱", R.drawable.plastic,
            "1) 종류\n" +
                "    ≡ PET병류 : 음료수병(주스, 콜라, 생수병 등), 간장병, 식용유병 등.\n" +
                "    ≡ 합성수지 용기류 : 각종 음식료 용기류, 야쿠르트병, 샴푸·세제용기류, 막걸리통, 물통, 우유통\n" +
                "    ≡ 일반 가정생활용품류 : 쓰레기통, 쓰레받이, 물바가지, 머리빗, 바구니 등\n" +
                "    ≡ 기타 용기류 : 맥주, 콜라, 사이다 등, 주류·음료수 상자\n" +
                "  2) 분리배출요령\n" +
                "    ≡ 뚜껑을 제거한 후, 내용물을 비우고 물로 한번 헹구어 배출한다.\n" +
                "    ≡ 가능한 압착하여 부피를 축소한다.\n" +
                "    ≡ 알루미늄 뚜껑은 고철로 분리 배출한다.\n" +
                "    ≡ 용기표면에 재질분류 표시 1,2,3,4,5,6번으로 표시된 플라스틱 제품에 한하여 배출한다.\n" ,
            R.drawable.plastic2,
            "3) 주의사항\n" +
                    "    ≡ 재활용이 어려운 다음의 플라스틱 제품은 제외한다.\n" +
                    "    ≡ 열에 잘 녹지 않는 플라스틱용기 : 전화기, 소켓, 다리미, 냄비의 손잡이, 전기전열기, 단추, 화장품 용기,\n" +
                    "       식기류, 재떨이, 쟁반 등\n" +
                    "    ≡ PVC류 용기 : 파이프, 빗물홈통, 장판, 전선 등\n" +
                    "    ≡ 복합재질 용기 : 과자, 라면봉지, 식품포장 용기 등\n" +
                    "    ≡ 기타 재활용 경제성이 없는 용기 : 가전제품 케이스, 함지박, 정화조, 비닐봉지, 볼펜 등 필기구, 1회용품 등\n" +
                    "    ≡ 플라스틱과 철사가 합성되어 있는 제품류(옷걸이 등)\n" +
                    "    ≡ 용기표면 재질분류표시 3,7번으로 표시된 플라스틱 제품"),

        HomeData(R.drawable.home_vinyl, "비닐", R.drawable.vinyl,
            "1) 종류\n" +
                    "    ≡ PET병류 : 음료수병(주스, 콜라, 생수병 등), 간장병, 식용유병 등.\n" +
                    "    ≡ 합성수지 용기류 : 각종 음식료 용기류, 야쿠르트병, 샴푸·세제용기류, 막걸리통, 물통, 우유통\n" +
                    "    ≡ 일반 가정생활용품류 : 쓰레기통, 쓰레받이, 물바가지, 머리빗, 바구니 등\n" +
                    "    ≡ 기타 용기류 : 맥주, 콜라, 사이다 등, 주류·음료수 상자\n" +
                    "  2) 분리배출요령\n" +
                    "    ≡ 뚜껑을 제거한 후, 내용물을 비우고 물로 한번 헹구어 배출한다.\n" +
                    "    ≡ 가능한 압착하여 부피를 축소한다.\n" +
                    "    ≡ 알루미늄 뚜껑은 고철로 분리 배출한다.\n" +
                    "    ≡ 용기표면에 재질분류 표시 1,2,3,4,5,6번으로 표시된 플라스틱 제품에 한하여 배출한다.\n" ,
            R.drawable.vinyl2,
            "3) 주의사항\n" +
                    "    ≡ 재활용이 어려운 다음의 플라스틱 제품은 제외한다.\n" +
                    "    ≡ 열에 잘 녹지 않는 플라스틱용기 : 전화기, 소켓, 다리미, 냄비의 손잡이, 전기전열기, 단추, 화장품 용기,\n" +
                    "       식기류, 재떨이, 쟁반 등\n" +
                    "    ≡ PVC류 용기 : 파이프, 빗물홈통, 장판, 전선 등\n" +
                    "    ≡ 복합재질 용기 : 과자, 라면봉지, 식품포장 용기 등\n" +
                    "    ≡ 기타 재활용 경제성이 없는 용기 : 가전제품 케이스, 함지박, 정화조, 비닐봉지, 볼펜 등 필기구, 1회용품 등\n" +
                    "    ≡ 플라스틱과 철사가 합성되어 있는 제품류(옷걸이 등)\n" +
                    "    ≡ 용기표면 재질분류표시 3,7번으로 표시된 플라스틱 제품"),

        HomeData(R.drawable.home_glass, "유리", R.drawable.glass,
            " 1) 종류 : 맥주·소주·음료수병, 드링크병, 약병, 기타 내용물을 담은 유리병, 농약병 및 각종 유리용기류.\n" +
                    "2) 분리배출요령 : ⼘플라스틱이나 알루미늄으로 된 뚜껑은 가급적 병목에 부착되어 있는 알루미늄 테까지 제거한 후 배출한다.\n" +
                    "    ≡ 병 속에 담배꽁초나 종이류 등 기타 이물질을 깨끗이 제거한 후 배출한다.\n" +
                    "    ≡ 맥주, 소주, 청량 음료병은 공병보증금제도의 실시로 슈퍼나 상점에서 보증금(40원∼50원)을 받고 교환한다.n",
            R.drawable.glass2,
            "3) 주의사항\n" +
                    "    ≡ 유리병중 유백색의 유리병은 재활용되지 않는다.\n" +
                    "    ≡ 거울, 깨진 유리, 도자기류, 내열식기류, 형광등, 전구 등도 재활용되지 않는다.\n" +
                    "    ≡ 농약 빈 병은 내용물을 완전히 사용한 후 다른 병류와 섞이지 않게 따로 마대에 모아 배출한다."),

        HomeData(R.drawable.home_iron, "고철", R.drawable.can,
            "1) 종류 : 공기구, 철사, 못, 철판 등 쇠붙이(소철), 양은, 스텐류, 구리, 알루미늄 샤시 등 (비철금속)\n" +
                    "2) 분리배출요령 : 식기류나 공구류에 붙어 있는 고무, 플라스틱 등 이물질을 제거한 후 가급적 부피를 줄여 묶거나 재활용 봉투에 넣어 배출한다.\n",
            R.drawable.can2,
            "3)주의사항 : 페인트, 오일통 등 유해물질 포장통과 폐유 용기는 재활용이 곤란하므로 제외한다."),

        HomeData(R.drawable.home_dress, "헌옷", R.drawable.dress,
            "1) 종류 : 양복, 양장, 면내의, 점퍼, 아동의류 등\n" +
                    "2) 분리배출요령 : 입을 수 없는 옷 등은 단추, 지퍼 등 이물질을 제거하고 물에 젖지 않게 하여 30㎝정도로 배출한다.\n",
            R.drawable.dress2,
            "3) 주의사항\n" +
                    "    ≡ 계획적인 구매로 불필요한 의류의 구입을 줄여 헌 의류의 발생을 줄여야 한다.\n" +
                    "    ≡ 입을 만한 옷을 깨끗이 빨아 이웃, 친척과 교환하여 입거나 불우이웃에 기증하도록 한다.\n" +
                    "    ≡ 한복, 담요, 솜, 베개, 카페트, 가죽제품, 1회용 기저귀, 방수 코팅된 옷은 제외한다."),

        HomeData(R.drawable.home_pack, "종이팩", R.drawable.paperpack,
            " 1) 종류 : 우유팩, 음료수 팩, 1회용 종이컵\\n\" +\n" +
                    "2) 분리배출요령 : 내용물을 비우고 물로 한번 헹군 후 납작하게 눌러 봉투에 넣거나 한데 묶어서 보관·배출한다.(그대로 말린 후 납작하게 눌러 묶어서 보관한다)\n",
            R.drawable.paperpack2,
             "3) 주의사항" +
                    "    ≡ 다른 종이류와 섞이지 않도록 별도의 분리 수거함을 마련토록 한다.\n" +
                    "    ≡ 우유팩이나 음료수팩 중 장기 보존용인 테트라팩은 재생이 안되므로 제외한다."),
    )
}