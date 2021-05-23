package com.udacity.shoestore.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Transformations

class ShoeViewModel:ViewModel(),Observable {

    private var Shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf(
            Shoe("Sneakers",13.0, "Nike","Red", mutableListOf("https://unsplash.com/photos/164_6wVEHfI")),
            Shoe("BluePrint Umbrella", 11.5,"UnderArmour","Black and White Leopard", mutableListOf("https://unsplash.com/photos/m6mAYVEHlNs")),
            Shoe("Toe heeled shoes",10.9,"Crocs Inc","Black leather peep", mutableListOf("https://unsplash.com/photos/sl963NLr3bI")),
            Shoe("Black men shoes",11.6,"Genesco.Inc","Patent leather heels", mutableListOf("https://image.shutterstock.com/image-vector/black-men-shoes-patent-leather-600w-252552370.jpg")),
            Shoe("Ethical shoe",11.5,"Deckers brand","For every occassion", mutableListOf("https://images.squarespace-cdn.com/content/v1/5442b6cce4b0cf00d1a3bef2/1617994517472-JHJRHEI85WBTG5G6B4BY/" +
                    "ke17ZwdGBToddI8pDm48kIgDQUuZGudwlQpLCqyQEt8UqsxRUqqbr1mOJYKfIPR7LoDQ9mXPOjoJoqy81S2I8PaoYXhp6HxIwZIk7-Mi3Tsic-L2IOPH3Dwrhl-Ne3Z2kDbnkgg-pjfVtIexCHLh42QYBHVOhwoS7bw-rX645trdZR9z9mxWb0yLUToVqwSd/ethical-shoe-brands-for-every-occasion-allbirds")),
            Shoe("Running Shoe", 10.4,"Weyco Group","Shallow focused", mutableListOf("https://unsplash.com/photos/Ijp_wDimUMc")),
            Shoe("Black men dress shoes",13.1,"Genesco","Shutter stock", mutableListOf("https://image.shutterstock.com/image-vector/mens-shoes-white-background-260nw-113109988.jpg")),
            Shoe("Low top sneakers", 10.9,"Adidas","Unpaired black and white", mutableListOf("https://unsplash.com/photos/Jq3IXFoEeUU")),
            Shoe("Air force sneaker", 12.2,"Nike","Unpaired off white", mutableListOf("https://unsplash.com/photos/PqbL_mxmaUE")),
            Shoe("Windorsmith men dress shoes", 13.1,"Windorsmith","Black", mutableListOf("https://www.windsorsmith.com.au/media/wysiwyg/00WINDSORSMITH/Home_Blocks/2021/2_LAWRENCE_JAN_2021.jpg"))
    ))




    private val propertyChangeRegistry = PropertyChangeRegistry()

    @get:Bindable
    var url= ""
        set(value) {
            field = value
        propertyChangeRegistry.notifyChange(this,BR.url)
        }


    //private val shoes = MutableLiveData<MutableList<Shoe>>(mutableListOf())
  //  Shoe(null,0.0,"company","description", mutableListOf(url))
    @Bindable
    var shoe= Shoe()
        set(value) {
            if (value != field) {
                field = value

                propertyChangeRegistry.notifyChange(this, BR.shoe)

            }
        }
        get






    fun addShoe(shoe: Shoe?) {

        shoe?.let {
            Shoes.value?.add(shoe)
        }
    }
    fun getShoeLiveData(): LiveData<MutableList<Shoe>> = Shoes

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        propertyChangeRegistry.remove(callback)
    }
}