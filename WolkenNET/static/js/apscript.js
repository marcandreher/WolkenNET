function safety(forward) {
    if (confirm('Diese Aktion wirklich ausführen, das kann nicht mehr rückgänig gemacht werden?')) {
        window.location.href = forward;
    }
}