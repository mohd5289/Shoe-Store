package com.udacity.shoestore

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.models.ShoeViewModel
import timber.log.Timber

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ShoeListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ShoeListFragment : Fragment() {
    // TODO: Rename and change types of parameters
  private  val viewModel:ShoeViewModel by activityViewModels()


    private lateinit var binding: FragmentShoeListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        // Inflate the layout for this fragment
        binding.lifecycleOwner=this

    //    val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            // Handle the back button event
      //  }

        val shoesObserver = Observer<MutableList<Shoe>> { it
            // Update the UI, in this case, a TextView.
            Timber.i(it.joinToString())
            if (it.isNotEmpty()) {
                loadShoes(it)
            }
        }
          viewModel.getShoeLiveData().observe(viewLifecycleOwner,shoesObserver)

//Implement Navigation
 binding.fab.setOnClickListener({
     view?.findNavController()?.navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailFragment())
 })

        setHasOptionsMenu(true)
        return binding.root

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.main, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_logout -> view?.findNavController()?.popBackStack()
        }
        return super.onOptionsItemSelected(item)
    }
    fun loadShoes(shoes: List<Shoe>) {
        context?.let { context ->
            val shoeContainer = binding.list
            shoes.forEach { shoe ->
                val shoeLayout = ShoeLayout(context)
                shoeLayout.loadShoe(shoe)
                shoeContainer.addView(shoeLayout)
            }
        }
    }


}