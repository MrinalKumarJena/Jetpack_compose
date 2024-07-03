Android App Lifecycle
__________________
onCreate()
Called when the activity is first created.
Initialize essential components, like views, data binding, etc.
Called only once during the entire activity lifetime.

onStart()
Called when the activity becomes visible to the user.
The app is now visible but not yet interactive.

onResume()
Called when the activity starts interacting with the user.
The app is now in the foreground and interactive.
Paired with onPause().

onPause()
Called when the system is about to start resuming another activity.
Save any unsaved changes, release resources like animations, etc.
The activity is still partially visible but not in the foreground.

onStop()
Called when the activity is no longer visible to the user.
Release resources that are not needed while the activity is not visible.
Paired with onStart().

onRestart()
Called after the activity has been stopped and just before it is started again.
Followed by onStart().

onDestroy()
Called before the activity is destroyed.
Cleanup resources, save data, etc.
Can be triggered by the system (e.g., low memory) or by calling finish().

Key Points:
____________
Activity States:
Created: Activity is being created.
Started: Activity is visible.
Resumed: Activity is in the foreground and interactive.
Paused: Activity is partially visible.
Stopped: Activity is not visible.
Destroyed: Activity is destroyed.

Lifecycle Callbacks:
onCreate(), onStart(), onResume(), onPause(), onStop(), onRestart(), and onDestroy().

Managing Resources:
Initialize resources in onCreate().
Acquire resources in onStart() and release in onStop().
Handle interactions in onResume() and pause them in onPause().
Clean up resources in onDestroy().
