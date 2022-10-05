package br.com.sodep.minetrackrwrk.costcenter.di

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import br.com.sodep.minetrackrwrk.costcenter.presenter.CostCenterViewModel
import org.koin.dsl.module

private val data = module {

}

private val domain = module {

}

private val presenter = module {
}

internal val allModules = listOf(data, domain, presenter)