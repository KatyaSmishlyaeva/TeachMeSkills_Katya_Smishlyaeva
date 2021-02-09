package com.example.smishlyaevakatya_android.homework23

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FurnitureViewModel : ViewModel() {

    val furnitureList = MutableLiveData<List<Furniture>>()

    fun setUp() {
        val listFurniture = listOf(
            Furniture(
                "Диван-кровать JESTRUP",
                "https://letto.by/image/cache/catalog/olmo-hetta-orion-valensia/olmo-priamoi-1270x760-auto_width_1000.jpg",
                true
            ),
            Furniture(
                "Кровать California. Бренд: Vegas",
                "https://www.vegas.by/upload/iblock/c9f/c9f9d66b00e9d3991ed7c05afe9c4c47.jpg",
                true
            ),
            Furniture(
                "Кровать-подиум КП-49",
                "https://images.tomas.by/i3/firms/49/5337/5337410/pic_cf604aff97434b8_1024x3000.jpg",
                false
            ),
            Furniture(
                "Денская кровать. Легенда 6 белая.",
                "https://images.tomas.by/i3/firms/49/5337/5337410/pic_04e58663123c66c_1024x3000.jpg",
                true
            ),
            Furniture(
                "Кресло Витио Velvet Yellow",
                "https://wowspace.ru/uploads/rent_item/preview_image/941/vitioye1.jpg",
                false
            ),
            Furniture(
                "Кресло для отдыха Angel зеленое",
                "https://virando.by/14407-thickbox_default/kreslo-dlya-otdykha-angel-rozovoe.jpg",
                true
            ),
            Furniture(
                "Стул полубарный Альта DC5188-P гусиная лапка",
                "https://alta-home.by/image/cache/catalog/newchinachair/dc2485bar/alta-dc-2485-b-kapuchino1-1000x1000.jpg",
                true
            ),
            Furniture(
                "Atreve Song (синий велюр/дуб)",
                "https://static.tildacdn.com/tild6666-3534-4232-b835-653461633633/389f02c26eb025a386dd.jpg",
                false
            ),
            Furniture(
                "Слот обеденный белый",
                "https://www.stool.by/image/cache/catalog/fort/krug/kruglyj-belyj-nogi-kvadro-slozhennyj-500x500.jpg",
                true
            ),
            Furniture(
                "Стол обеденный с ореховой столещницей",
                "https://bytsennosti.by/1648-large_default/stol-obedennyj-ovalnyj-francuzskij-tunis.jpg",
                true
            ),
            Furniture(
                "Стол письменный \"Каньон\" П561.30",
                "https://images.tomas.by/i3/firms/49/5339/5339051/stol-pismennyy-kompyuternyy-m1_2e9f2236d4d90af_1024x3000.jpg",
                true
            )
        )
        furnitureList.value = listFurniture
    }
}