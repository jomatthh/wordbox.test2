package com.wordbox.test2.presentation.person.view

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.mdp.test.base.BaseFragment
import com.wordbox.test2.databinding.FragmentPersonBinding
import com.wordbox.test2.presentation.person.adapter.PersonAdapter
import com.wordbox.test2.presentation.person.model.PersonModel
import org.koin.androidx.viewmodel.ext.android.getViewModel

class PersonFragment : BaseFragment<FragmentPersonBinding>(FragmentPersonBinding::inflate),
    PersonAdapter.OnPersonaApterListener {

    private val viewModel: PersonViewModel by lazy { getViewModel() }
    private val adapter by lazy {
        PersonAdapter(emptyList(), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
        setupObservers()
        viewModel.getAll()
    }

    private fun setupAdapter() {
        binding.personFRvItems.layoutManager = LinearLayoutManager(requireContext())
        binding.personFRvItems.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.persons.observe(viewLifecycleOwner) {
            adapter.update(it)
        }
    }

    override fun itemClick(model: PersonModel) {
        val action = PersonFragmentDirections.actionPersonFragmentToPersonDetailFragment(model)
        findNavController().navigate(action)
    }
}