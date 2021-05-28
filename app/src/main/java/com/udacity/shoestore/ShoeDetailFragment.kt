package com.udacity.shoestore

import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController

import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel
import timber.log.Timber
import javax.xml.datatype.DatatypeFactory.newInstance

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeDetailFragment : Fragment() {

    private lateinit var binding:FragmentShoeDetailBinding

    private val viewModel: ShoeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)
        binding.lifecycleOwner = this



        binding.shoeViewModel = viewModel
      //  binding.shoe = Shoe()
       viewModel.createNewShoe()


        binding.save.setOnClickListener {
            viewModel.addShoe(viewModel.currentShoe)




             view?.findNavController()?.navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())

        }

        binding.cancel.setOnClickListener({
            view?.findNavController()?.navigate(ShoeDetailFragmentDirections.actionShoeDetailFragmentToShoeListFragment())
        })
        // Inflate the layout for this fragment
        return binding.root
    }


}