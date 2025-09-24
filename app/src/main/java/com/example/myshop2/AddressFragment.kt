package com.example.myshop2

import android.R
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.myshop2.databinding.FragmentAddressBinding


/**
 * A simple [Fragment] subclass.
 * Use the [AddressFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddressFragment : Fragment() {

    private var _binding: FragmentAddressBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddressBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            // resources.getStringArray(R.array.prov)
            // val provinces = resources.getStringArray(android.R.array.provinces)
            val provinces = listOf("Aceh", "Gorontalo")

            val adapterProvinces = ArrayAdapter(
                requireContext(),
                android.R.layout.simple_spinner_dropdown_item,
                provinces)

            spinnerProvinces.adapter = adapterProvinces

            btnDone.setOnClickListener {
                findNavController().apply { // apply nilai ke savestateHandle
                    previousBackStackEntry?.savedStateHandle?.set("address", spinnerProvinces.selectedItem.toString())
                }
                    .navigateUp() // navigateUp()
            }
        }
    }


}