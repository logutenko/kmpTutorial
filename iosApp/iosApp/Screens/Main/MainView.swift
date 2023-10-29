//
//  MainView.swift
//  iosApp
//
//  Created by hackline on 29/10/2023.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI

struct MainView: View {
    var body: some View {
        TabView {
            HomeScreen()
                .tabItem {
                    Label("Home", systemImage: "house")
                }
            SearchScreen()
                .tabItem {
                    Label("Search", systemImage: "magnifyingglass")
                    
                }
            
            EventsScreen()
                .tabItem {
                    Label("Events", systemImage: "person.fill")
                }
            
            VideosScreen()
                .tabItem {
                    Label("Videos", systemImage: "person.fill")
                }
            
        }
    }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}
