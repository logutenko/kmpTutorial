//
//  CommonTextField.swift
//  iosApp
//
//  Created by hackline on 27/10/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct CommonTextField: View {
    
    @State private var value: String = ""
    
    private let hint: String
    private let enabled: Bool
    private let isSecure: Bool
    private let onValueChanged: (String) -> Void
    
    init(hint: String, enabled: Bool = true, isSecure: Bool = false,
         onValueChanged: @escaping (String) -> Void) {
        self.hint = hint
        self.enabled = enabled
        self.isSecure = isSecure
        self.onValueChanged = onValueChanged
        
    }
    
    var body: some View {
        ZStack(alignment: .leading) {
            RoundedRectangle(cornerRadius: 10)
                .foregroundColor(.backgroundSecondary)
            
            if (value.isEmpty) {
                Text(hint)
                    .foregroundColor(Color.textPrimary.opacity(0.5))
                    .padding(EdgeInsets(top: 0, leading: 16, bottom: 0, trailing: 16))
                    .font(.system(size: 16))
                
                
            }
            
            if (isSecure) {
                SecureField("", text: $value)
                    .foregroundColor(.textPrimary)
                    .font(.system(size: 16))
                    .autocapitalization(.none)
                    .disableAutocorrection(true)
                    .disabled(!enabled)
                    .padding(EdgeInsets(top: 0, leading: 16, bottom: 0, trailing: 16))
                    .onChange(of: value) {newValue in
                        onValueChanged(newValue)
                    }
            } else {
                TextField("", text: $value)
                    .foregroundColor(.textPrimary)
                    .font(.system(size: 16))
                    .autocapitalization(.none)
                    .disableAutocorrection(true)
                    .disabled(!enabled)
                    .padding(EdgeInsets(top: 0, leading: 16, bottom: 0, trailing: 16))
                    .onChange(of: value) {newValue in
                        onValueChanged(newValue)
                    }
            }
            

        }
        .frame(height: 56)
        .padding(EdgeInsets(top: 0, leading: 16, bottom: 0, trailing: 24))
    }
}

struct CommonTextField_Previews: PreviewProvider {
    static var previews: some View {
        CommonTextField(hint: "Your Email"){
            newValue in
            print(newValue)
        }
    }
}
