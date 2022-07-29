package br.com.impacta.cepretrofit

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.impacta.cepretrofit.data.models.CEP
import br.com.impacta.cepretrofit.data.remote.PostmonAPI
import br.com.impacta.cepretrofit.data.remote.Rede
import br.com.impacta.cepretrofit.databinding.FragmentHomeBinding
import retrofit2.*


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = Rede.getRetrofitInstance("https://api.postmon.com.br")
        val endpointPostmon = retrofit.create(PostmonAPI::class.java)

        binding.button.setOnClickListener {
            if (binding.editTextTextPersonName.text.isNotEmpty()) {

                val chamada =
                    endpointPostmon.getCEPInfo(binding.editTextTextPersonName.text.toString())

                chamada.enqueue(object : Callback<CEP>{
                    override fun onResponse(call: Call<CEP>, response: Response<CEP>) {
                        response.body()?.let {
                            binding.textView.text = it.toString()
                        }
                    }

                    override fun onFailure(call: Call<CEP>, t: Throwable) {
                        Log.e("IMPACTA", t.printStackTrace().toString())
                    }

                })

            }
        }
    }


}