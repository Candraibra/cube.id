package com.candraibra.barvolume.ui.login


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.candraibra.barvolume.R
import com.candraibra.barvolume.ui.home.BottomNavActivity

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment(), View.OnClickListener {
    private lateinit var navController: NavController

    private lateinit var btnLogin: Button
    private lateinit var btnForgot: Button
    private lateinit var btnRegister: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btnLogin = view.findViewById(R.id.btnLogin)
        btnForgot = view.findViewById(R.id.btnForgot)
        btnRegister = view.findViewById(R.id.btnRegister)

        btnLogin.setOnClickListener(this)
        btnForgot.setOnClickListener(this)
        btnRegister.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnRegister -> navController.navigate(R.id.action_loginFragment_to_registerFragment)
            R.id.btnLogin -> {
                val intent = Intent(activity, BottomNavActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }
            R.id.btnForgot -> navController.navigate(R.id.action_loginFragment_to_forgotFragment)
        }
    }


}
