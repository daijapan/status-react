(ns status-im.ui.screens.wallet.wallet-list.views
  (:require-macros [status-im.utils.views :refer [defview]])
  (:require [clojure.string :as string]
            [re-frame.core :as rf]
            [status-im.components.drawer.view :as drawer]
            [status-im.components.react :as rn]
            [status-im.components.toolbar-new.view :as toolbar]
            [status-im.components.toolbar-new.actions :as act]
            [status-im.i18n :as i18n]
            [status-im.utils.listview :as lw]
            [status-im.utils.platform :refer [platform-specific]]
            [status-im.ui.screens.wallet.wallet-list.styles :as st]))

(defn toolbar-view [transactions]
  [toolbar/toolbar {:title "Wallets"
                    :nav-action (act/hamburger drawer/open-drawer)}])

(defn wallet-list-item [[id {:keys [name currency amount assets color] :as row}]]
  (let [asset-list (string/upper-case (string/join "  " (map clojure.core/name assets)))]
    [rn/view {:style (st/wallet-item color)}
     [rn/view {:style st/wallet-info}
      [rn/text {:style st/wallet-name} name]
      [rn/view {:style st/total-balance}
       [rn/text {:style st/total-balance-value} amount]
       [rn/text {:style st/total-balance-currency} "USD"]]
      [rn/text {:style st/asset-list} asset-list]]
     [rn/image {:source {:uri :icon_back_gray}
                :style st/select-wallet-icon}]]))

(defn render-row-fn [row _ _]
  (rn/list-item
   [rn/touchable-highlight {:on-press #()}
    [rn/view
     [wallet-list-item row]]]))

;; TODO When theres 4+ wallets, they are hidden by the tabs.
;; needs to be tested as a standalone screen
(defn wallet-list []
  (let [wallets {"1" {:name     "Main wallet"
                      :currency :usd
                      :amount   12.43
                      :assets   [:snt :sgt :gno :eth]
                      :color    :blue-1}
                 "2" {:name     "Other wallet"
                      :currency :usd
                      :amount   0.34
                      :assets   [:eth]
                      :color    :gray-1}}]
    [rn/scroll-view {:style st/wallet-list-screen}
     [rn/text {:style st/wallet-list-title} "Your wallets"]
     [rn/list-view {:scrollEnabled  false
                    :dataSource      (lw/to-datasource wallets)
                    :renderRow       render-row-fn}]]))

(defview screen []
  []
  [rn/view {:style st/screen-container}
   [toolbar-view]
   [wallet-list]])
