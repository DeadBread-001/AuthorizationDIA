import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.example.authorization.MainActivity
import com.example.authorization.R
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {

    private lateinit var editTextUsername: EditText
    private lateinit var editTextPassword: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        editTextUsername = view.findViewById(R.id.editTextUsername)
        editTextPassword = view.findViewById(R.id.editTextPassword)

        val buttonLogin = view.findViewById<Button>(R.id.buttonLogin)
        buttonLogin.setOnClickListener { attemptLogin() }

        return view
    }

    private fun attemptLogin() {
        val username = editTextUsername.text.toString()
        val password = editTextPassword.text.toString()

        if (isValidCredentials(username, password)) {
            (activity as? MainActivity)?.showWelcomeFragment(username)
        } else {
            showErrorMessage("Wrong username or password")
        }
    }

    private fun isValidCredentials(username: String, password: String): Boolean {
        return username.isNotEmpty() && password == "123321"
    }

    private fun showErrorMessage(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_SHORT).show()
    }
}
