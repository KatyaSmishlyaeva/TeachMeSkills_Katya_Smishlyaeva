package com.example.smishlyaevakatya_navigation.ui.homework25

import androidx.lifecycle.*
import com.example.smishlyaevakatya_navigation.ui.homework26.repository.FurnitureRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class FurnitureViewModel(var repository: FurnitureRepository) : ViewModel() {

    val allFurniture: LiveData<List<Furniture>> = repository.allFurniture


    fun addFurniture(furniture: Furniture) = viewModelScope
        .launch(Dispatchers.IO) {
            repository.addFurniture(furniture)
        }

    fun deleteFurniture(furniture: Furniture) = viewModelScope
        .launch(Dispatchers.IO) {
            repository.deleteFurniture(furniture)
        }

    val listFurniture = listOf(
        Furniture(
            "Диван-кровать JESTRUP-2035." +
                    " 200$",
            "https://letto.by/image/cache/catalog/olmo-hetta-orion-valensia/olmo-priamoi-1270x760-auto_width_1000.jpg",
            "Склад"
        ),
        Furniture(
            "Кровать California. Бренд: Vegas." +
                    " 700$",
            "https://www.vegas.by/upload/iblock/c9f/c9f9d66b00e9d3991ed7c05afe9c4c47.jpg",
            "Склад"
        ),
        Furniture(
            "Кровать-подиум КП-49." +
                    " 420$",
            "https://images.tomas.by/i3/firms/49/5337/5337410/pic_cf604aff97434b8_1024x3000.jpg",
            "Склад"
        ),
        Furniture(
            "Денская кровать. Легенда 6-89-9 белая." +
                    " 590$",
            "https://images.tomas.by/i3/firms/49/5337/5337410/pic_04e58663123c66c_1024x3000.jpg",
            "Склад"
        ),
        Furniture(
            "Кресло Витио Velvet-9087 Yellow." +
                    " 320$",
            "https://wowspace.ru/uploads/rent_item/preview_image/941/vitioye1.jpg",
            "Склад"
        ),
        Furniture(
            "Кресло для отдыха Angel-9878 зеленое." +
                    " 400$",
            "https://virando.by/14407-thickbox_default/kreslo-dlya-otdykha-angel-rozovoe.jpg",
            "Склад"
        ),
        Furniture(
            "Стул полубарный Альта DC5188-P гусиная лапка." +
                    " 120$",
            "https://alta-home.by/image/cache/catalog/newchinachair/dc2485bar/alta-dc-2485-b-kapuchino1-1000x1000.jpg",
            "Склад"
        ),
        Furniture(
            "Atreve Song-234 (синий велюр/дуб)." +
                    " 270$",
            "https://static.tildacdn.com/tild6666-3534-4232-b835-653461633633/389f02c26eb025a386dd.jpg",
            "Склад"
        ),
        Furniture(
            "Слот обеденный белый." +
                    " 280$",
            "https://www.stool.by/image/cache/catalog/fort/krug/kruglyj-belyj-nogi-kvadro-slozhennyj-500x500.jpg",
            "Склад"
        ),
        Furniture(
            "Стол обеденный с ореховой столещницей." +
                    " 390$",
            "https://bytsennosti.by/1648-large_default/stol-obedennyj-ovalnyj-francuzskij-tunis.jpg",
            "Склад"
        ),
        Furniture(
            "Стол письменный \"Каньон\" П561.30-90." +
                    " 220S",
            "https://images.tomas.by/i3/firms/49/5339/5339051/stol-pismennyy-kompyuternyy-m1_2e9f2236d4d90af_1024x3000.jpg",
            "Склад"
        )
    )
}

class FurnitureViewModelFactory(private val repository: FurnitureRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FurnitureViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return FurnitureViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}