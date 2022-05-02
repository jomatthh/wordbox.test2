package com.wordbox.test2.presentation.person_detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.mdp.test.base.BaseFragment
import com.wordbox.test2.databinding.FragmentPersonDetailBinding
import com.wordbox.test2.presentation.person.model.PersonModel

class PersonDetailFragment :
    BaseFragment<FragmentPersonDetailBinding>(FragmentPersonDetailBinding::inflate) {

    private val args: PersonDetailFragmentArgs by navArgs()
    private lateinit var model: PersonModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = args.model
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupData()
    }

    private fun setupData() = with(binding) {
        personItemFTvName.text = model.name
        Glide.with(binding.root.context).load(model.pictureUrl).into(personItemFIvIcon)
        personItemFTvGender.text = model.gender
        personItemFTvAge.text = model.age.toString()
        personItemFTvCity.text = model.city
        personItemFTvEmail.text = model.email
    }
}