//
//  LoginScreen.swift
//  iosApp
//
//  Created by hackline on 28/10/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import SharedSDK

struct LoginScreen: View {
    
    @State private var isForgotPresented = false
    @State private var isRegistrationPresented = false
    @State private var isMainFlowPresented = false
    
    private let loginViewModel = LoginViewModel()
    
    var body: some View {
        ObservingView(statePublisher: statePublisher(loginViewModel.viewStates())) { viewState in
            LoginView(viewState: viewState) { event in
                loginViewModel.obtainEvent(viewEvent: event)
            }
        }
        .sheet(isPresented: $isForgotPresented, content: {
            ForgotScreen()
        })
        .sheet(isPresented: $isRegistrationPresented, content: {
            RegistrationScreen()
        })
        .fullScreenCover(isPresented: $isMainFlowPresented, content: {
            MainView()
        })
        .onReceive(sharedPublisher(loginViewModel.viewActions())) { action in
            switch(action) {
            case LoginAction.OpenForgotPasswordScreen():
                isForgotPresented = true
            case LoginAction.OpenRegistrationScreen():
                isRegistrationPresented = true                
            case LoginAction.OpenMainFlow():
                isMainFlowPresented = true
                
            default:
                break
            }
        }
    }
}
