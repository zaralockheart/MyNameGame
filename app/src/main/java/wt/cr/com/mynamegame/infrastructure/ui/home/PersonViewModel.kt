package wt.cr.com.mynamegame.infrastructure.ui.home

import android.databinding.ObservableBoolean
import android.databinding.ObservableField
import android.databinding.ViewDataBinding
import com.xwray.groupie.databinding.BindableItem
import wt.cr.com.mynamegame.domain.model.MyModel
import wt.cr.com.mynamegame.infrastructure.common.utils.LiveDataActionWithData
import wt.cr.com.mynamegame.infrastructure.ui.BaseBindableViewModel

class PersonViewModel(private val numerino: String, private val person: MyModel.Person, val personClickListener: (PersonViewModel) -> Unit): BaseBindableViewModel(){
    //observables
    val number = ObservableField<String>(numerino)
    val name = ObservableField<String>(person.firstName)
    val url = ObservableField<String>("http:${person.headshot.url}")
    var visible = ObservableBoolean(true)

    override fun getItemFactory(): (BaseBindableViewModel) -> BindableItem<ViewDataBinding> {
        return { it -> PersonItem((it as PersonViewModel)) }
    }

    fun onClick() {
        personClickListener(this)
    }
}