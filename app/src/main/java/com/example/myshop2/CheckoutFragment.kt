package com.example.myshop2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.navigateUp
import com.example.myshop2.databinding.FragmentCheckoutBinding

// * A simple [Fragment] subclass.
// * Use the [CheckoutFragment.newInstance] factory method to
// * create an instance of this fragment.
// */
class CheckoutFragment : Fragment() {

    private var _binding: FragmentCheckoutBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCheckoutBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // baca argumen yang dikirim dari home

        with(binding) {
            val args: CheckoutFragmentArgs by navArgs()
            var productName = args.productName

            // set text menjadi product Name
            txtProductName.text = productName

            // kalau edit text address di klik
            edtAddress.setOnClickListener {
                // buat action untuk navigasi ke address
                var action = CheckoutFragmentDirections.actionCheckoutFragmentToAddressFragment()
                // cari navigation controller dr host
                findNavController().navigate(action)
            }
            // ambil data yang dikirim oleh addressFragment
            findNavController()
                .currentBackStackEntry
                ?.savedStateHandle
                ?.let { handle ->
                    handle.getLiveData<String>("address")
                        .observe(viewLifecycleOwner) { res ->
                            edtAddress.setText(res)
                        }
                }
            btnDone.setOnClickListener {
                findNavController().navigateUp()
            }
        }
    }

}