package com.junkfood.seal.ui.page

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Subscriptions
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material.icons.outlined.Download
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Subscriptions
import androidx.compose.material.icons.outlined.Terminal
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.unit.dp
import com.junkfood.seal.R
import com.junkfood.seal.ui.common.Route
import com.junkfood.seal.ui.theme.SealBrand

/** Bottom navigation for compact screens: Queue, Library, Commands, Settings. */
@Composable
fun SealBottomBar(
    currentRoute: String?,
    onNavigateToRoute: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(color = MaterialTheme.colorScheme.background, modifier = modifier) {
        Column(modifier = Modifier.navigationBarsPadding()) {
            HorizontalDivider(color = MaterialTheme.colorScheme.outlineVariant)
            Row(modifier = Modifier.fillMaxWidth().height(64.dp).selectableGroup()) {
                val home = currentRoute == Route.HOME
                BottomBarItem(
                    selected = home,
                    label = stringResource(R.string.nav_queue),
                    icon = if (home) Icons.Filled.Download else Icons.Outlined.Download,
                    onClick = { onNavigateToRoute(Route.HOME) },
                )
                val library = currentRoute == Route.DOWNLOADS
                BottomBarItem(
                    selected = library,
                    label = stringResource(R.string.nav_library),
                    icon = if (library) Icons.Filled.Subscriptions else Icons.Outlined.Subscriptions,
                    onClick = { onNavigateToRoute(Route.DOWNLOADS) },
                )
                val commands = currentRoute == Route.TASK_LIST
                BottomBarItem(
                    selected = commands,
                    label = stringResource(R.string.nav_commands),
                    icon = if (commands) Icons.Filled.Terminal else Icons.Outlined.Terminal,
                    onClick = { onNavigateToRoute(Route.TASK_LIST) },
                )
                val settings = currentRoute == Route.SETTINGS_PAGE
                BottomBarItem(
                    selected = settings,
                    label = stringResource(R.string.settings),
                    icon = if (settings) Icons.Filled.Settings else Icons.Outlined.Settings,
                    onClick = { onNavigateToRoute(Route.SETTINGS_PAGE) },
                )
            }
        }
    }
}

@Composable
private fun RowScope.BottomBarItem(
    selected: Boolean,
    label: String,
    icon: ImageVector,
    onClick: () -> Unit,
) {
    val color =
        if (selected) MaterialTheme.colorScheme.onSurface
        else MaterialTheme.colorScheme.onSurfaceVariant
    Box(
        modifier =
            Modifier.weight(1f)
                .fillMaxHeight()
                .selectable(selected = selected, role = Role.Tab, onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        if (selected) {
            Box(
                modifier =
                    Modifier.align(Alignment.TopCenter)
                        .width(24.dp)
                        .height(2.dp)
                        .background(SealBrand.Gradient)
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = color, modifier = Modifier.size(22.dp))
            Text(text = label, style = MaterialTheme.typography.labelSmall, color = color, maxLines = 1)
        }
    }
}
