//
//  ActionButton.swift
//  iosApp
//
//  Created by hackline on 27/10/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct ActionButton: View {
    let title: String
    var enabled: Bool = true
    let height: CGFloat = 56
    let hotizontalMargin: CGFloat = 16
    let action: () -> Void
    
    var body: some View {
        ZStack {
            RoundedRectangle(cornerRadius: 10)
                .foregroundColor(.tintColor)
                .opacity(enabled ? 1.0 : 0.5)
            
            Text(title)
                .foregroundColor(.textAction)
        }
        .frame(maxWidth: .infinity, minHeight: height)
        .padding(EdgeInsets(top: 0, leading: hotizontalMargin, bottom: 0, trailing: hotizontalMargin))
        .onTapGesture {
            action()
        }
    }
}

struct ActionButton_Previews: PreviewProvider {
    static var previews: some View {
        ActionButton(title: "Login Now"){
            
        }
    }
}
