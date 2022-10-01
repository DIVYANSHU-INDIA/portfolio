import { enableProdMode } from '@angular/core';
import { platformBrowserDynamic } from '@angular/platform-browser-dynamic';

import { AppModule } from './app/app.module';
import { environment } from './environments/environment';

if (environment.production) {
  enableProdMode();
}

platformBrowserDynamic().bootstrapModule(AppModule)
  .catch(err => console.error(err));

  const flavoursContainer = document.getElementById('sc');
  const flavoursScrollWidth = flavoursContainer!.scrollWidth;
    
    window.addEventListener('load', () => {
      self.setInterval(() => {
        if (flavoursContainer!.scrollLeft !== flavoursScrollWidth) {
          flavoursContainer!.scrollTo(flavoursContainer!.scrollLeft + 1, 0);
        }
      }, 15);
    });