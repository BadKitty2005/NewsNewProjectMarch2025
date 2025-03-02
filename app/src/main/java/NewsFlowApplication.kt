import android.app.Application
import com.example.newsnewprojectmarch2025.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NewsFlowApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NewsFlowApplication)
            modules(appModule)
        }
    }
}