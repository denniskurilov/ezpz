/* =====================================================================
   EZPZ - Employee Registry
   Shared scripts for all pages (static template, no backend calls)
   ===================================================================== */

/* ---------- Theme (light / dark) ----------
   Runs immediately (script is loaded in <head>) to avoid a flash
   of the wrong theme. Falls back to the OS preference. */
(function () {
    const STORAGE_KEY = 'ezpz-theme';

    function storedTheme() {
        try {
            return localStorage.getItem(STORAGE_KEY);
        } catch (e) {
            return null;
        }
    }

    function preferredTheme() {
        const stored = storedTheme();
        if (stored === 'light' || stored === 'dark') {
            return stored;
        }
        return window.matchMedia('(prefers-color-scheme: dark)').matches ? 'dark' : 'light';
    }

    function applyTheme(theme) {
        document.documentElement.setAttribute('data-bs-theme', theme);
        document.querySelectorAll('[data-theme-icon]').forEach(function (icon) {
            icon.className = theme === 'dark' ? 'bi bi-sun' : 'bi bi-moon-stars';
        });
    }

    applyTheme(preferredTheme());

    document.addEventListener('DOMContentLoaded', function () {
        applyTheme(preferredTheme());

        document.querySelectorAll('[data-theme-toggle]').forEach(function (button) {
            button.addEventListener('click', function () {
                const next = document.documentElement.getAttribute('data-bs-theme') === 'dark' ? 'light' : 'dark';
                try {
                    localStorage.setItem(STORAGE_KEY, next);
                } catch (e) {
                    // storage unavailable - theme just won't be remembered
                }
                applyTheme(next);
            });
        });
    });
})();

document.addEventListener('DOMContentLoaded', function () {

    /* ---------- index.html: delete confirmation ---------- */
    const deleteModal = document.getElementById('deleteModal');
    if (deleteModal) {
        deleteModal.addEventListener('show.bs.modal', function (event) {
            const button = event.relatedTarget;
            deleteModal.querySelector('[data-delete-name]').textContent = button.getAttribute('data-name');
            deleteModal.querySelector('[data-delete-id]').textContent = button.getAttribute('data-id');
        });

        document.getElementById('confirmDelete').addEventListener('click', function () {
            // Template only: real deletion will be wired to the backend later
            bootstrap.Modal.getInstance(deleteModal).hide();
        });
    }

    /* ---------- employee.html: form ---------- */
    const form = document.getElementById('employeeForm');
    if (form) {
        // Opened via "Add employee" (no ?id=...) - show an empty form
        const params = new URLSearchParams(window.location.search);
        if (!params.has('id')) {
            document.getElementById('pageTitle').textContent = 'New employee';
            ['id', 'createdAt', 'firstName', 'lastName', 'dateOfBirth'].forEach(function (fieldId) {
                document.getElementById(fieldId).value = '';
            });
            document.getElementById('id').placeholder = 'Auto';
            document.getElementById('createdAt').placeholder = 'Assigned automatically';
        }

        form.addEventListener('submit', function (event) {
            event.preventDefault();
            if (!form.checkValidity()) {
                form.classList.add('was-validated');
                return;
            }
            // Template only: saving will be wired to the backend later
            window.location.href = 'index.html';
        });

        document.getElementById('confirmCancel').addEventListener('click', function () {
            window.location.href = 'index.html';
        });
    }
});
