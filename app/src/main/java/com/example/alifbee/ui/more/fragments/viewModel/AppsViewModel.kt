package com.example.alifbee.ui.more.fragments.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.alifbee.api.Retr
import com.example.alifbee.model.AppsRes
import com.example.alifbee.model.TheApps
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import java.util.*

class AppsViewModel : ViewModel() {
    private val _ourApps = MutableLiveData<List<TheApps>>()
    var ourApps: LiveData<List<TheApps>> = _ourApps

    init {
        getOurApps()
    }

    private  fun getOurApps() {
        CoroutineScope(Dispatchers.IO).launch {
            val jsonApps = try {
                Retr.api.getApps()
            } catch (e: IOException) {
                null
            } catch (e: HttpException) {
                null
            }
            if (jsonApps?.isSuccessful == true && jsonApps.body() != null) {
                val theApps: AppsRes = jsonApps.body()!!
                if (Locale.getDefault().language == Locale("ar").language)
                    _ourApps.postValue(theApps.body.our_apps.ar)
                else {
                    _ourApps.postValue(theApps.body.our_apps.en)
                }
            }else{
                _ourApps.postValue(listOf(TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),
                    TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),
                    TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),
                    TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),
                    TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),
                    TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),
                    TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),
                    TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),
                    TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),TheApps("https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt","https://arabee.s3.eu-central-1.amazonaws.com/icons/alifbee_.jpg","tt"),))
            }
        }
    }
}