package com.example.pet_project.ui.main

import android.util.Log
import androidx.appcompat.widget.SearchView
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.pet_project.BaseApp
import com.example.pet_project.model.hero.Result
import com.example.pet_project.network.Interactor
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.PublishSubject
import javax.inject.Inject

@InjectViewState
class MainPresenter : MvpPresenter<MainViewInterface>(), ClickListener {

    private val compositeDisposable = CompositeDisposable()

    @Inject
    lateinit var interactor: Interactor

    init {
        BaseApp.instance.component.inject(this)
    }

    fun getHeroList() {
        interactor.getHeroList()
            .subscribe({
                viewState.showHeroList(it)
            },
                { throwable -> Log.e("showErrorMessage", "showErrorMessage $throwable") })
            .run(compositeDisposable::add)
    }

    fun getHeroListBasedOnName(searchView: SearchView) {
        interactor.getHeroListBasedOnName(fromView(searchView))
            .subscribe({
                viewState.showHeroList(it)
            },
                { throwable -> Log.e("showErrorMessage", "showErrorMessage $throwable") })
    }

    private fun fromView(searchView: SearchView): Observable<String> {
        val subject: PublishSubject<String> = PublishSubject.create()
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(text: String?): Boolean {
                subject.onNext(text)
                return true
            }

            override fun onQueryTextChange(text: String?): Boolean {
                subject.onNext(text)
                return true
            }
        })
        return subject
    }

    override fun onItemClick(selectedHero: Result) {
        viewState.openFragment(selectedHero)
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}