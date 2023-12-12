import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.authorization.MainActivity
import com.example.authorization.R

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_welcome, container, false)

        val username = arguments?.getString("username")

        val textView = view.findViewById<TextView>(R.id.textView)
        textView.text = "Welcome, $username!"

        val buttonBackToLogin = view.findViewById<Button>(R.id.buttonBackToLogin)
        buttonBackToLogin.setOnClickListener {
            (activity as? MainActivity)?.showLoginFragment()
        }

        return view
    }
}