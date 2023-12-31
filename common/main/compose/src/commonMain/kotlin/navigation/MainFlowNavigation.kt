package navigation

import androidx.compose.material.Text
import home.HomeScreen
import navigation.tabs.BottomConfiguration
import navigation.tabs.EventsTab
import navigation.tabs.HomeTab
import navigation.tabs.SearchTab
import navigation.tabs.VideosTab
import ru.alexgladkov.odyssey.compose.extensions.bottomNavigation
import ru.alexgladkov.odyssey.compose.extensions.screen
import ru.alexgladkov.odyssey.compose.extensions.tab
import ru.alexgladkov.odyssey.compose.navigation.RootComposeBuilder
import search.SearchScreen

fun RootComposeBuilder.mainFlow() {
    bottomNavigation(
        name = NavigationTree.Main.Dashboard.name,
        tabsNavModel = BottomConfiguration()
    ) {
        println("Test Main flow")
        tab(HomeTab()) {
            screen(name = NavigationTree.Main.Home.name) {
                HomeScreen()
            }

            screen(name = NavigationTree.Main.Profile.name) {
                Text("Hello profile")
            }
        }

        tab(SearchTab()) {
            screen(name = NavigationTree.Main.Search.name) {
                SearchScreen()
            }
        }

        tab(EventsTab()) {
            screen(name = NavigationTree.Main.Events.name) {
            }
        }

        tab(VideosTab()) {
            screen(name = NavigationTree.Main.Videos.name) {
            }
        }
    }
}